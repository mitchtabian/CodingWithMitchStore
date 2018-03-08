package pluralsight.com.codingwithmitchstore.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * Created by User on 3/3/2018.
 */

public class Product implements Parcelable{

    private String title;
    private int image;
    private String type;
    private BigDecimal price;
    private int serial_number;

    public Product(String title, int image, String type, BigDecimal price, int serial_number) {
        this.title = title;
        this.image = image;
        this.type = type;
        this.price = price;
        this.serial_number = serial_number;
    }

    public Product(Product product) {
        this.title = product.title;
        this.image = product.image;
        this.type = product.type;
        this.price = product.price;
        this.serial_number = product.serial_number;
    }

    protected Product(Parcel in) {
        title = in.readString();
        image = in.readInt();
        type = in.readString();
        serial_number = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(image);
        dest.writeString(type);
        dest.writeInt(serial_number);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



}
