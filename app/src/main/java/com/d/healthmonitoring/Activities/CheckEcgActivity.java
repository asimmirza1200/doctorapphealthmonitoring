package com.d.healthmonitoring.Activities;

import android.os.Bundle;
import android.util.Log;

import com.d.healthmonitoring.Model.ECG;
import com.d.healthmonitoring.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CheckEcgActivity extends AppCompatActivity {
    GraphView graph;
    private double graphLastXValue = 0d;

    private LineGraphSeries<DataPoint> series;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ecg);

        graph = (GraphView) findViewById(R.id.graph);
        final LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);
        series.setDrawDataPoints(false);
        series.setDrawBackground(false);
        series.setDrawAsPath(true);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setScalable(true);
        graph.setHorizontalScrollBarEnabled(true);
        graph.getViewport().setMaxX(500);
        graph.getGridLabelRenderer().setLabelVerticalWidth(100);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) + "";
                }
            }
        });
// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sensor/ecg");
// Read from the database
        final DataPoint[] dataPoints={};
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ECG value = dataSnapshot.getValue(ECG.class);
                Log.d("TAG", "Value is: " + value.getEcg());
                graphLastXValue += 2.00d;
                series.appendData(new DataPoint(graphLastXValue, Double.parseDouble(value.getEcg().trim().isEmpty()?"0":value.getEcg())), true, 500);
                graph.getViewport().scrollToEnd();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    }
