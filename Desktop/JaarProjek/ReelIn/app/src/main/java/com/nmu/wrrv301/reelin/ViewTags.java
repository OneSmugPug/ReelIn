package com.nmu.wrrv301.reelin;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Date;

public class ViewTags extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tags);

        DummyTag dummyTag1 = new DummyTag("1234",new Date(),"fishSpecies1", 33,35,10,4);
        DummyTag dummyTag2 = new DummyTag("2314",new Date(),"fishSpecies2", 50,55,23,13);
        DummyTag dummyTag3 = new DummyTag("4553",new Date(),"fishSpecies3", 25,37,30,8);
        DummyTag dummyTag4 = new DummyTag("6234",new Date(),"fishSpecies4", 90,110,40,23);
        DummyTag dummyTag5 = new DummyTag("8663",new Date(),"fishSpecies5", 4,7,3,1);

        String[] arraySpinner = new String[]{
                dummyTag1.getTagID(), dummyTag2.getTagID(), dummyTag3.getTagID(), dummyTag4.getTagID(), dummyTag5.getTagID()
        };
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySpinner);
        Spinner s = (Spinner) findViewById(R.id.tagSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void findLocation(View view){
        Intent intent = new Intent(this, LocationCaptured.class);
        startActivity(intent);
    }

    public void removeTag(View view){
        Spinner s = (Spinner) findViewById(R.id.tagSpinner);
        adapter.remove(s.getItemAtPosition(s.getSelectedItemPosition()).toString());
        adapter.notifyDataSetChanged();
    }

    public class DummyTag{
        private String tagID;
        private Date dateCaptured;
        private String fishSpecies;
        private int forkLength;
        private int totalLength;
        private int precLength;
        private int weight;
        private int diskWidth;
        private Location locationCaptured;

        DummyTag(String tagId, Date dateCaptured, String fishSpecies, int forkLength, int totalLength, int precLength, int weight){
            this.tagID = tagId;
            this.dateCaptured = dateCaptured;
            this.fishSpecies = fishSpecies;
            this.forkLength = forkLength;
            this.totalLength = totalLength;
            this.precLength = precLength;
            this.weight = weight;
        }

        String getTagID() {
            return tagID;
        }

        public void setTagID(String tagID) {
            this.tagID = tagID;
        }

        public Date getDateCaptured() {
            return dateCaptured;
        }

        public void setDateCaptured(Date dateCaptured) {
            this.dateCaptured = dateCaptured;
        }

        public String getFishSpecies() {
            return fishSpecies;
        }

        public void setFishSpecies(String fishSpecies) {
            this.fishSpecies = fishSpecies;
        }

        public int getForkLength() {
            return forkLength;
        }

        public void setForkLength(int forkLength) {
            this.forkLength = forkLength;
        }

        public int getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(int totalLength) {
            this.totalLength = totalLength;
        }

        public int getPrecLength() {
            return precLength;
        }

        public void setPrecLength(int precLength) {
            this.precLength = precLength;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getDiskWidth() {
            return diskWidth;
        }

        public void setDiskWidth(int diskWidth) {
            this.diskWidth = diskWidth;
        }

        public Location getLocationCaptured() {
            return locationCaptured;
        }

        public void setLocationCaptured(Location locationCaptured) {
            this.locationCaptured = locationCaptured;
        }
    }
}
