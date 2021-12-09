package com.example.felixdelafuente.customlistview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Integrative Programming", "Android Programming", "iOS Programming", "Computer Fundamentals", "Object Oriented Programming", "Discrete Math", "Database Management"};
    String mDescription[] = {"ICTN05C", "DCSN06C", "ELECL3C", "CFPL01E", "CSCN02C", "ITEN02C", "DCSN05C"};
    int images[] = {R.drawable.gray, R.drawable.red, R.drawable.orange, R.drawable.yellow, R.drawable.green, R.drawable.blue, R.drawable.violet};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(MainActivity.this, "ICTN05C", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                }
                if (position ==  1) {
                    Toast.makeText(MainActivity.this, "DCSN06C", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity3.class));
                }
                if (position ==  2) {
                    Toast.makeText(MainActivity.this, "ELECL3C", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity4.class));
                }
                if (position ==  3) {
                    Toast.makeText(MainActivity.this, "CFPL01E", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity5.class));
                }
                if (position ==  4) {
                    Toast.makeText(MainActivity.this, "CSCN02C", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity6.class));
                }
                if (position ==  5) {
                    Toast.makeText(MainActivity.this, "ITEN02C", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity7.class));
                }
                if (position ==  6) {
                    Toast.makeText(MainActivity.this, "DCSN05C", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity8.class));
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
