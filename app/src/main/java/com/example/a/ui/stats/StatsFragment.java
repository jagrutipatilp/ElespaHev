package com.example.a.ui.stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.a.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StatsFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public StatsFragment() {
        // Required empty public constructor
    }


    public static StatsFragment newInstance(String param1, String param2) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        GraphView graphView = view.findViewById(R.id.graph);

        // Sample data points
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(getSampleDataPoints());

        // Customize the series if needed
        series.setColor(getResources().getColor(R.color.teal_700));
        series.setSpacing(40); // Adjust this value to make bars thinner or thicker

        // Setting manual X bounds to have control over the viewport
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(10); // Assuming 10 data points
        graphView.getViewport().setXAxisBoundsManual(true);

        // Set recent date labels
        setRecentDateLabels(graphView);

        // Add labels to axes
        graphView.getGridLabelRenderer().setVerticalAxisTitle("Distance (km)");
        graphView.getGridLabelRenderer().setHorizontalAxisTitle("Recent Dates");

        // Adding the series to the graph
        graphView.addSeries(series);

        return view;
    }
    private DataPoint[] getSampleDataPoints() {
        // Sample data points
        return new DataPoint[]{
                new DataPoint(0, 5),
                new DataPoint(1, 10),
                new DataPoint(2, 15),
                new DataPoint(3, 20),
                new DataPoint(4, 25),
                new DataPoint(5, 30),
                new DataPoint(6, 35),

                new DataPoint(7, 3),
                new DataPoint(8, 15),
                new DataPoint(9, 33),
                new DataPoint(10, 35),

                // Add more data points as needed
        };
    }

    private void setRecentDateLabels(GraphView graphView) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d", Locale.getDefault());
        DataPoint[] datePoints = new DataPoint[10];

        for (int i = 0; i < 10; i++) {
            datePoints[i] = new DataPoint(i, 0); // The Y-value is set to 0, adjust as needed
            calendar.add(Calendar.DAY_OF_YEAR, -1); // Subtract one day
        }

        // Set date labels
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        String[] dateLabels = new String[10];
        for (int i = 0; i < 10; i++) {
            dateLabels[i] = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR, 1); // Move to the next day
        }
        staticLabelsFormatter.setHorizontalLabels(dateLabels);
        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
    }
}
