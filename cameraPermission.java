// Function to check and request permission
public void checkPermission(String permission, int requestCode)
{
	// Checking if permission is not granted
	if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
		ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, requestCode);
	}
	else {
		Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
	}
}
