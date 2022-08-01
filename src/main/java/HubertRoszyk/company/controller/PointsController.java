package HubertRoszyk.company.controller;

import HubertRoszyk.company.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PointsController {
    @Autowired
    PointsService pointsService;
}
