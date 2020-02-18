package pl.kolban.SpringCarRental.service;

import org.springframework.stereotype.Service;
import pl.kolban.SpringCarRental.BlogRepository;

@Service
public class CarService {

    BlogRepository blogRepository;

    public CarService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Object findCar(String id){
        int idCar = Integer.parseInt(id);
        Object carId = blogRepository.findById(idCar);
        if (carId != null) {
            return carId;
        } else {
            return null;
        }
    }

}
