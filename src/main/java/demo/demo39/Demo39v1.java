package demo.demo39;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

enum VideoStatus{
    STANDART,
    POPULAR

}
class Video39{
    private AtomicReference<VideoStatus> status = new AtomicReference<>(VideoStatus.STANDART);
    private final AtomicReference<CopyOnWriteArrayList<String>> comments = new AtomicReference<CopyOnWriteArrayList<String>>(new CopyOnWriteArrayList<>());
    private AtomicInteger commentCount= new AtomicInteger(0);

    public void getComments(String comment){
        comments.updateAndGet(v->{
            v.addLast(comment);
            if (commentCount.incrementAndGet()>10){
                changeStatus();
            }
            return v;
        });
    }

    public void changeStatus(){
        status.updateAndGet(v->VideoStatus.POPULAR);
    }

    public AtomicReference<CopyOnWriteArrayList<String>> getCommentsList() {
        return comments;
    }

    public AtomicReference<VideoStatus> getStatus() {
        return status;
    }
}
public class Demo39v1 {
    public static void main(String[] args) throws InterruptedException {
        Video39 video = new Video39();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0; i<11; i++){
            executorService.submit(()->{
                video.getComments(Thread.currentThread().getName()+" commented something.");
            });
        }

        Thread.sleep(3000);
        executorService.shutdown();
        System.out.println(video.getStatus().get());
        for (String comment :video.getCommentsList().get()) {
            System.out.println(comment);
        }
    }
}
