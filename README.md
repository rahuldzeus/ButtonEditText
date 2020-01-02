# ButtonEditText

# ButtonEditText

Step 1: Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
  
  or

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://www.jitpack.io</url>
		</repository>
	</repositories>
	
  Step 2: Add the dependency
  
 	dependencies {
	        implementation 'com.github.rahuldzeus.ButtonEditText:buttonedittext:170fd3f4c4'
	}
  
  or
  
	<dependency>
	    <groupId>com.github.rahuldzeus.ButtonEditText</groupId>
	    <artifactId>buttonedittext</artifactId>
	    <version>170fd3f4c4</version>
	</dependency>
	
Step 3: Find the view

	 CustomEditButton customEditButton = findViewById(R.id.llButton);
	 
Step 4: Button click callback

	customEditButton.setOnButtonClickListener(new CustomEditButton.OnButtonClickListener() {
            @Override
            public void onClick(View view) {
                /*On Button Clicked*/
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_LONG).show();
            }
        });
	
Step 5 (Optional): Fetch EditText value using OnValueChangeListener

	customEditButton.setOnValueChangeListener(new CustomEditButton.OnValueChangeListener() {
            @Override
            public void onValueChange(String value) {
                /*Geting realtime value here*/
            }
        });
	
Step 6 (Optional): Get the EditText value without OnValueChangeListener

	editText = ((EditText) customEditButton.getChildAt(0).findViewById(R.id.tvCustomEditText));
	String data = editText.getText().toString().trim();
	


Attributes:

app:editTextTitle - Set Hint of EditText
app:editBackground -Set Background Color of EditText
	
  
