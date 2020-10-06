package test2;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;

import com.example.videotest.R;

public class MainActivity2 extends Activity {

    Button button;
    DownloadManager downloadManager;
    private VideoView videoView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVisibility(View.INVISIBLE);
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://ia800201.us.archive.org/22/items/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                Long reference = downloadManager.enqueue(request);

              if(DownloadManager.STATUS_SUCCESSFUL == 1){

                    videoView.setVisibility(View.VISIBLE);
                    videoView.setVideoURI(downloadManager.getUriForDownloadedFile(reference));
                    videoView.start();
                }
            }

        });
    }

}