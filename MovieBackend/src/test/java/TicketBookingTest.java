import static org.junit.Assert.*;
import com.tickets.TicketBooking;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TicketBookingTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @org.junit.Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.Test
    public void testBookTickets() {
        TicketBooking tb = new TicketBooking();

        // Test Case 1
        ByteArrayInputStream in1 = new ByteArrayInputStream("1\nB1,B4\nYes\n1\nB1,B3\nYes\n2\nA1,A2,A3\nNo\n".getBytes());
        System.setIn(in1);
        tb.bookTickets();
        String output1 = """
                Enter Show No.: Enter seats: Successfully Booked - Show 1
                Subtotal: Rs. 560
                Service Tax @14%: Rs. 78.40
                Swachh Bharat Cess @0.5%: Rs. 2.80
                Krishi Kalyan Cess @0.5%: Rs. 2.80
                Total: Rs. 644
                Would you like to continue (Yes/No): Enter Show No.: Enter seats: B1 Not available, Please select different seats
                Would you like to continue (Yes/No): Enter Show No.: Enter seats: Successfully Booked - Show 2
                Subtotal: Rs. 960
                Service Tax @14%: Rs. 134.40
                Swachh Bharat Cess @0.5%: Rs. 4.80
                Krishi Kalyan Cess @0.5%: Rs. 4.80
                Total: Rs. 1104
                Would you like to continue (Yes/No): Total Sales:
                Revenue: Rs. 1520A
                Service Tax: Rs.212.80
                Swachh Bharat Cess: Rs.7.60
                Krishi Kalyan Cess: Rs.7.60""".replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(output1, outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));

    }

    @org.junit.After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}