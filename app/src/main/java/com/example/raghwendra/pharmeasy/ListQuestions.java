package com.example.raghwendra.pharmeasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by raghawendra.kumar on 12-04-2016.
 */
public class ListQuestions extends AppCompatActivity {
    public ParcelListAdapter mAdapter;
    RecyclerView rvItems;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listquestion_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvItems =(RecyclerView)findViewById(R.id.lvGenericList);
        rvItems.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(mLayoutManager);
        bindData();
    }

    public void bindData() {
        System.out.println("Start request" + Calendar.getInstance().getTime().toString());
        String dataURL = "https://api.stackexchange.com/2.2/search/advanced?order=desc&sort=activity&accepted=False&answers=0&tagged=android&site=stackoverflow";
        Ion.with(this)
                .load(dataURL)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                        if (result == null) {
                            //preventing from crash in case of failure
                            return;
                        }
                        ObjectMapper mapper = new ObjectMapper();
                        ArrayList<ModelItem> matchingParcels = new ArrayList<>();
                        JsonArray getArray = result.getAsJsonArray("items");
                        for (Object tempObj : getArray) {
                            ModelItem tempParcel = null;

                            try {
                                tempParcel = mapper.readValue(tempObj.toString(), ModelItem.class);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            if (tempParcel != null) {
                                matchingParcels.add(tempParcel);
                            }
                        }
                        System.out.println("Raghu :" + matchingParcels.toString());
                        mAdapter = new ParcelListAdapter(getApplicationContext(), matchingParcels);
                        rvItems.setAdapter(mAdapter);

                    }
                });
    }

    public static Float precision(int decimalPlace, Float d) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}

