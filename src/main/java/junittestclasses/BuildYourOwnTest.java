package junittestclasses;

import com.example.rupizzeria.BuildYourOwn;
import com.example.rupizzeria.Size;
import com.example.rupizzeria.Toppings;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildYourOwnTest {

    /**
     * The price of a small, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $8.99 + ($1.59 * 0)
     */
    @Test
    public void test_price_of_small_pizza_zero_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);

        double expected = 8.99;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a small, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $8.99 + ($1.59 * 1)
     */
    @Test
    public void test_price_of_small_pizza_one_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);
        Toppings topping1 =  Toppings.SAUSAGE;
        pizza.add(topping1);

        double expected = 8.99 + 1.59;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a small, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $8.99 + ($1.59 * 7)
     */
    @Test
    public void test_price_of_small_pizza_seven_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);

        Toppings topping1 =  Toppings.SAUSAGE;
        pizza.add(topping1);
        Toppings topping2 =  Toppings.PEPPERONI;
        pizza.add(topping2);
        Toppings topping3 =  Toppings.GREEN_PEPPER;
        pizza.add(topping3);
        Toppings topping4 =  Toppings.ONION;
        pizza.add(topping4);
        Toppings topping5 =  Toppings.MUSHROOM;
        pizza.add(topping5);
        Toppings topping6 =  Toppings.BBQ_CHICKEN;
        pizza.add(topping6);
        Toppings topping7 =  Toppings.PROVOLONE;
        pizza.add(topping7);

        double expected = 8.99 + 7 * 1.59;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a medium, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $10.99 + ($1.59 * 0)
     */
    @Test
    public void test_price_of_medium_pizza_zero_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.MEDIUM);

        double expected = 10.99;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a medium, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $10.99 + ($1.59 * 1)
     */
    @Test
    public void test_price_of_medium_pizza_one_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.MEDIUM);
        Toppings topping1 =  Toppings.SAUSAGE;
        pizza.add(topping1);

        double expected = 10.99 + 1.59;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a medium, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $10.99 + ($1.59 * 7)
     */
    @Test
    public void test_price_of_medium_pizza_seven_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.MEDIUM);

        Toppings topping1 =  Toppings.SAUSAGE;
        pizza.add(topping1);
        Toppings topping2 =  Toppings.PEPPERONI;
        pizza.add(topping2);
        Toppings topping3 =  Toppings.GREEN_PEPPER;
        pizza.add(topping3);
        Toppings topping4 =  Toppings.ONION;
        pizza.add(topping4);
        Toppings topping5 =  Toppings.MUSHROOM;
        pizza.add(topping5);
        Toppings topping6 =  Toppings.BBQ_CHICKEN;
        pizza.add(topping6);
        Toppings topping7 =  Toppings.PROVOLONE;
        pizza.add(topping7);

        double expected = 10.99 + 7 * 1.59;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a large, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $12.99 + ($1.59 * 0)
     */
    @Test
    public void test_price_of_large_pizza_zero_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.LARGE);

        double expected = 12.99;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a large, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $12.99 + ($1.59 * 1)
     */
    @Test
    public void test_price_of_large_pizza_one_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.LARGE);
        Toppings topping1 =  Toppings.SAUSAGE;
        pizza.add(topping1);

        double expected = 12.99 + 1.59;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

    /**
     * The price of a large, build your own pizza:
     * base cost + (number of toppings * topping price)
     * So $12.99 + ($1.59 * 7)
     */
    @Test
    public void test_price_of_large_pizza_seven_toppings() {
        BuildYourOwn pizza = new BuildYourOwn();
        pizza.setSize(Size.LARGE);

        Toppings topping1 =  Toppings.SAUSAGE;
        pizza.add(topping1);
        Toppings topping2 =  Toppings.PEPPERONI;
        pizza.add(topping2);
        Toppings topping3 =  Toppings.GREEN_PEPPER;
        pizza.add(topping3);
        Toppings topping4 =  Toppings.ONION;
        pizza.add(topping4);
        Toppings topping5 =  Toppings.MUSHROOM;
        pizza.add(topping5);
        Toppings topping6 =  Toppings.BBQ_CHICKEN;
        pizza.add(topping6);
        Toppings topping7 =  Toppings.PROVOLONE;
        pizza.add(topping7);

        double expected = 12.99 + 7 * 1.59;
        double actual = pizza.price();

        assertEquals(expected, actual);
    }

}