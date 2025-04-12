package com.Intellivort.AutoSaveAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Intellivort.AutoSaveAPI.Entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
