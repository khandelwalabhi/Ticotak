Button btnShow = new Button(this);
btnShow.setText(R.string.show_text);
btnShow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
btnShow.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, R.string.welcome_message, Toast.LENGTH_LONG).show();
    }
});

// Add Button to LinearLayout
if (linearLayout != null) {
    linearLayout.addView(btnShow);
}
