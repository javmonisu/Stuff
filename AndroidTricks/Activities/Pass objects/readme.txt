you have to implement parcelable. Also you have to create a new constructor with an argumment: A Parcel.
You must create a method for readFromParcel, when you read from that parcel.
Finally you can read the object writting:
  Information information = extras.getParcelable("information");
