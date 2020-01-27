package com.example.piechart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    float rainfall[] = {155.2f,128.3f,134.29f,167.2f,25.3f,45.9f,78.36f,43.8f,199f,145f,458.3f,158f};
    String monthNames[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        piechart();

    }

    private void piechart() {
        List<PieEntry> p = new ArrayList<>();
        for (int i= 0;i< rainfall.length;i++)
        {
            p.add(new PieEntry(rainfall[i],monthNames[i]));
        }
        PieDataSet datas = new PieDataSet(p,"Rainfall in Piechart");
        datas.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(datas);

        PieChart chart = (PieChart) findViewById(R.id.chart);

        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();
    }

}
