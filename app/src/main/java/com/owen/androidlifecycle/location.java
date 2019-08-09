private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {
            Log.d(TAG, "getLocation: permissions granted");
        }
    } 
    
    @Override
public void onRequestPermissionsResult(int requestCode,
 @NonNull String[] permissions, @NonNull int[] grantResults) {
    switch (requestCode) {
        case REQUEST_LOCATION_PERMISSION:
            // If the permission is granted, get the location,
            // otherwise, show a Toast
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                Toast.makeText(this,
                        R.string.location_permission_denied,
                        Toast.LENGTH_SHORT).show();
            }
            break;
    }
}

    mFusedLocationClient.getLastLocation().addOnSuccessListener(
           new OnSuccessListener<Location>() {
    @Override
    public void onSuccess(Location location) {
       if (location != null) {
           mLastLocation = location;
           mLocationTextView.setText(
                   getString(R.string.location_text,
                           mLastLocation.getLatitude(),
                           mLastLocation.getLongitude(),
                           mLastLocation.getTime()));
       } else {
           mLocationTextView.setText(R.string.no_location);
       }
    }
    private class FetchAddressTask extends AsyncTask<Location, Void, String> {
       private final String TAG = FetchAddressTask.class.getSimpleName();
       private Context mContext;

       FetchAddressTask(Context applicationContext) {
            mContext = applicationContext;
       }

       @Override
       protected String doInBackground(Location... locations) {
           return null;
       }
       @Override
       protected void onPostExecute(String address) {
           super.onPostExecute(address);
       }
    }
