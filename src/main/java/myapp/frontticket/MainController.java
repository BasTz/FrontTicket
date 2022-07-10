package myapp.frontticket;

import Model.Customer;
import Model.Movie;
import Model.Showtime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {

    @RequestMapping(value = "/movie",method = RequestMethod.GET)
    public String MovieController(ModelMap model){
        Movie[] movies;

        try {
            final String uri = "http://ticket:8080/movie";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Movie[]> response = restTemplate.getForEntity(uri, Movie[].class);
            movies = response.getBody();
        }
        catch (Exception e){
            final String uri = "http://localhost:8080/movie";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Movie[]> response = restTemplate.getForEntity(uri, Movie[].class);
            movies = response.getBody();

        }

        List<Movie> movieList = new ArrayList<>();
        assert movies != null;
        Collections.addAll(movieList, movies);

        model.addAttribute("movies",movieList);
        return "movie";
    }

    @RequestMapping(value = "/booking",method = RequestMethod.GET)
    public String BookingController(ModelMap model){
        Customer[] customers;
        try {
            final String uri = "http://ticket:8080/customer";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Customer[]> response = restTemplate.getForEntity(uri, Customer[].class);
            customers = response.getBody();
        }
        catch (Exception e){
            final String uri = "http://localhost:8080/customer";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Customer[]> response = restTemplate.getForEntity(uri, Customer[].class);
            customers = response.getBody();
        }

        assert customers != null;
        List<Customer> customerList = new ArrayList<>(Arrays.asList(customers));

        model.addAttribute("customer",customerList);
        return "booking";
    }

    @RequestMapping(value = "/showtime",method = RequestMethod.GET)
    public String ShowtimeController(ModelMap model){

        try {
            final String urishowtime = "http://ticket:8080/showtime";
            final String urimovie = "http://ticket:8080/movie";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Showtime[]> response = restTemplate.getForEntity(urishowtime, Showtime[].class);
            Showtime[] showtimes = response.getBody();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            List<Showtime> showtimeList = new ArrayList<>();
            assert showtimes != null;
            for (Showtime showtime : showtimes) {
                if (formatter.format(showtime.getDatetime()).equals(formatter.format(date))) {
                    showtimeList.add(showtime);
                }
            }

            ResponseEntity<Movie[]> response1 = restTemplate.getForEntity(urimovie, Movie[].class);
            Movie[] movies = response1.getBody();

            List<Movie> movieList = new ArrayList<>();
            assert movies != null;
            Collections.addAll(movieList, movies);

            model.addAttribute("showtime",showtimeList);
            model.addAttribute("movies",movieList);
        }
        catch (Exception e){
            final String urishowtime = "http://localhost:8080/showtime";
            final String urimovie = "http://localhost:8080/movie";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Showtime[]> response = restTemplate.getForEntity(urishowtime, Showtime[].class);
            Showtime[] showtimes = response.getBody();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            List<Showtime> showtimeList = new ArrayList<>();
            assert showtimes != null;
            for (Showtime showtime : showtimes) {
                if (formatter.format(showtime.getDatetime()).equals(formatter.format(date))) {
                    showtimeList.add(showtime);
                }
            }

            ResponseEntity<Movie[]> response1 = restTemplate.getForEntity(urimovie, Movie[].class);
            Movie[] movies = response1.getBody();

            List<Movie> movieList = new ArrayList<>();
            assert movies != null;
            Collections.addAll(movieList, movies);

            model.addAttribute("showtime",showtimeList);
            model.addAttribute("movies",movieList);
        }
        return "showtime";
    }

    @RequestMapping(value = "/showtimebyid/{id}",method = RequestMethod.GET)
    public String ShowtimeByID(@PathVariable int id,ModelMap model){

        try {
            final String uricustomerbyshowtime = "http://ticket:8080/showtimebymovie/" + id;
            final String urimovie = "http://ticket:8080/movie";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Showtime[]> response = restTemplate.getForEntity(uricustomerbyshowtime, Showtime[].class);
            Showtime[] showtimebyid = response.getBody();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            List<Showtime> showtimeList = new ArrayList<>();
            assert showtimebyid != null;
            for (Showtime showtime : showtimebyid) {
                if (formatter.format(showtime.getDatetime()).equals(formatter.format(date))) {
                    showtimeList.add(showtime);
                }
            }

            ResponseEntity<Movie[]> response1 = restTemplate.getForEntity(urimovie, Movie[].class);
            Movie[] movies = response1.getBody();

            List<Movie> movieList = new ArrayList<>();
            assert movies != null;
            Collections.addAll(movieList, movies);

            model.addAttribute("showtime", showtimeList);
            model.addAttribute("movies", movieList);
        }
        catch (Exception e){
            final String uricustomerbyshowtime = "http://localhost:8080/showtimebymovie/" + id;
            final String urimovie = "http://localhost:8080/movie";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Showtime[]> response = restTemplate.getForEntity(uricustomerbyshowtime, Showtime[].class);
            Showtime[] showtimebyid = response.getBody();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            List<Showtime> showtimeList = new ArrayList<>();
            assert showtimebyid != null;
            for (Showtime showtime : showtimebyid) {
                if (formatter.format(showtime.getDatetime()).equals(formatter.format(date))) {
                    showtimeList.add(showtime);
                }
            }

            ResponseEntity<Movie[]> response1 = restTemplate.getForEntity(urimovie, Movie[].class);
            Movie[] movies = response1.getBody();

            List<Movie> movieList = new ArrayList<>();
            assert movies != null;
            Collections.addAll(movieList, movies);

            model.addAttribute("showtime", showtimeList);
            model.addAttribute("movies", movieList);
        }
        return "showtime";
    }
}
