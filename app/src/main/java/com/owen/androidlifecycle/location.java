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
try {
   addresses = geocoder.getFromLocation(
           location.getLatitude(),
           location.getLongitude(),
           // In this sample, get just a single address
           1);
}
                   catch (IOException ioException) {
   // Catch network or other I/O problems
   resultMessage = mContext
           .getString(R.string.service_not_available);
   Log.e(TAG, resultMessage, ioException);
}
                   catch (IllegalArgumentException illegalArgumentException) {
   // Catch invalid latitude or longitude values
   resultMessage = mContext
           .getString(R.string.invalid_lat_long_used);
   Log.e(TAG, resultMessage + ". " +
           "Latitude = " + location.getLatitude() +
           ", Longitude = " +
           location.getLongitude(), illegalArgumentException);
}
                  
                   if (addresses == null || addresses.size() == 0) {
   if (resultMessage.isEmpty()) {
       resultMessage = mContext
               .getString(R.string.no_address_found);
       Log.e(TAG, resultMessage);
   }
}
                     else {
       // If an address is found, read it into resultMessage
       Address address = addresses.get(0);
       ArrayList<String> addressParts = new ArrayList<>();

       // Fetch the address lines using getAddressLine,
       // join them, and send them to the thread
       for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
           addressParts.add(address.getAddressLine(i));
       }

       resultMessage = TextUtils.join("\n", addressParts);
    }
                   nterface OnTaskCompleted {
        void onTaskCompleted(String result);
}
                   
                   
                   
                   
                   
                   
