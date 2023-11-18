package dars.dars39;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

enum VideoYoutubeStatus{
    NORMAL,
    POPULAR,
    NEGATIV_POPULAR
}
class VideoYoutube{
    private AtomicInteger views = new AtomicInteger(0);
    private AtomicInteger dislikes = new AtomicInteger(0);
    private AtomicReference<VideoYoutubeStatus> status = new AtomicReference<>(VideoYoutubeStatus.NORMAL);

    public void viewDone(){
        views.updateAndGet(v->{
            int x = views.get()+1;
            if (x>10 && dislikes.get()<10){
                status.set(VideoYoutubeStatus.POPULAR);
            }
            System.out.println(Thread.currentThread().getName()+" view");

            return x;
        });
    }

    public void doDislike(){
        dislikes.updateAndGet(v->{
            int x = dislikes.get()+1;
            if (x>10){
                status.set(VideoYoutubeStatus.NEGATIV_POPULAR);
            }
            System.out.println(Thread.currentThread().getName()+" dodislike");
            return x;
        });
    }

    public AtomicInteger getViews() {
        return views;
    }

    public AtomicInteger getDislikes() {
        return dislikes;
    }

    public AtomicReference<VideoYoutubeStatus> getStatus() {
        return status;
    }
}
public class Exmple39v5 {
    public static void main(String[] args) throws InterruptedException {
        VideoYoutube obj = new VideoYoutube();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i=0; i<20; i++){
            service.submit(obj::viewDone);
        }

        for (int i=0; i<20; i++){
            service.submit(obj::doDislike);
        }

        Thread.sleep(3000);
        System.out.println(obj.getDislikes().get());
        System.out.println(obj.getViews().get());
        System.out.println(obj.getStatus().get());

        service.shutdown();
    }
}
