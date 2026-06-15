package io.novustrack.backend.controller;

import io.novustrack.backend.model.Habit;
import io.novustrack.backend.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {
    private HabitService habitService;

    public HabitController (HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<Habit> getAllHabits (){
        return habitService.getAllHabits();
    }

    @PostMapping
    public Habit createNewHabit (@RequestBody Habit habit){
        return habitService.createNewHabit(habit.getName(), habit.getDescription());
    }
}