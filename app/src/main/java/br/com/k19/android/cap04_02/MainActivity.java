package br.com.k19.android.cap04_02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button viewSiteButton = (Button) findViewById(R.id.view_site_button);
        Button sendEmailButton = (Button) findViewById(R.id.send_email_button);
        Button makeCallButton = (Button) findViewById(R.id.make_call_button);


        sendEmailButton.setOnClickListener(new View.OnClickListener() {


                                              @Override
                                              public void onClick(View v) {

                                               Intent intent = new Intent(Intent.ACTION_SEND

                                                       );
                                                intent.setType("plain/text");
                                                  intent.putExtra(Intent.EXTRA_EMAIL, new String[]{
                                                          "rbsa@a.ifpe.recife.edu.br"
                                                  });

                                                  startActivity(Intent.createChooser(intent, "Enviar email"));

                                              }
                                          }
        );

         viewSiteButton.setOnClickListener(new View.OnClickListener() {


                                               @Override
                                               public void onClick(View v) {

                                                   Intent intent = new Intent(Intent.ACTION_VIEW,
                                                           Uri.parse("http://www.google.com.br")
                                                   );
                                                   startActivity(intent);

                                               }
                                           }
         );

        makeCallButton.setOnClickListener(new View.OnClickListener() {


                                              @Override
                                              public void onClick(View v) {

                                                  Intent intent = new Intent(Intent.ACTION_DIAL,
                                                          Uri.parse("tel:+5590908185121548")
                                                  );
                                                  startActivity(intent);

                                              }
                                          }
        );



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
