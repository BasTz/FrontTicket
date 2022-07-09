package myapp.frontticket;

import Model.Customer;
import Model.Movie;
import Model.Showtime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = "/movie",method = RequestMethod.GET)
    public String MovieController(ModelMap model){
        final String uri = "http://localhost:8080/movie";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie[]> response = restTemplate.getForEntity(uri, Movie[].class);
        Movie[] movies = response.getBody();

        List<Movie> movieList = new ArrayList<>();
        assert movies != null;
        Collections.addAll(movieList, movies);

        /*String test = "";
        for (Movie movie:movies) {
            String temp = "<td style=\"border: 1px solid;\">" + movie.getId() +"</td>";
            temp += "<td style=\"border: 1px solid;\">" + movie.getName() +"</td>";
            test += "<tr>" + temp + "</tr>";
        }*/

        model.addAttribute("movies",movieList);
        return "movie";
    }

    @RequestMapping(value = "/booking",method = RequestMethod.GET)
    public String BookingController(ModelMap model){
        final String uri = "http://localhost:8080/customer";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(uri, Customer[].class);
        Customer[] customers = response.getBody();

        assert customers != null;
        List<Customer> customerList = new ArrayList<>(Arrays.asList(customers));

        /*String test = "";
        for (Movie movie:movies) {
            String temp = "<td style=\"border: 1px solid;\">" + movie.getId() +"</td>";
            temp += "<td style=\"border: 1px solid;\">" + movie.getName() +"</td>";
            test += "<tr>" + temp + "</tr>";
        }*/

        model.addAttribute("customer",customerList);
        return "booking";
    }

    @RequestMapping(value = "/showtime",method = RequestMethod.GET)
    public String ShowtimeController(ModelMap model){
        final String uri = "http://localhost:8080/showtime";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Showtime[]> response = restTemplate.getForEntity(uri, Showtime[].class);
        Showtime[] showtimes = response.getBody();

        assert showtimes != null;
        List<Showtime> showtimeList = new ArrayList<>(Arrays.asList(showtimes));

        /*String test = "";
        for (Movie movie:movies) {
            String temp = "<td style=\"border: 1px solid;\">" + movie.getId() +"</td>";
            temp += "<td style=\"border: 1px solid;\">" + movie.getName() +"</td>";
            test += "<tr>" + temp + "</tr>";
        }*/

        model.addAttribute("showtime",showtimeList);
        return "showtime";
    }
}
