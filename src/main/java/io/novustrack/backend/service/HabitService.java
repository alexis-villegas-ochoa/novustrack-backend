package io.novustrack.backend.service;

import io.novustrack.backend.model.Habit;
import io.novustrack.backend.repository.HabitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitService {
    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getAllHabits (){
        return habitRepository.findAll();
    }

    public Habit createNewHabit (String name, String description){
        Habit newHabit = new Habit(name, description);
        return habitRepository.save(newHabit);
    }
}