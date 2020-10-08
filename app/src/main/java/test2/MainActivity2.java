package test2;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.telecom.InCallService;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;

import com.example.videotest.R;

public class MainActivity2 extends Activity {

    Button button;
    DownloadManager downloadManager;
    Uri vidurl = Uri.parse("https://ia800201.us.archive.org/22/items/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");
    Uri ex = Uri.parse("http://help.websico.net/fr/data/rawdata/exemple_pdf.pdf");
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(vidurl);
                //request.setTitle("Ma_vidéo.mp4");
                request.setDescription("Téléchargement de votre vidéo depuis le lien");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
             //   request.setDestinationUri(Uri.parse("/MAVIDEO.mp4"));
                request.setDestinationInExternalFilesDir(getApplication().getApplicationContext(), Environment.DIRECTORY_MOVIES, "Ma_vidéo.mp4");

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);


        }

        });
    }

}