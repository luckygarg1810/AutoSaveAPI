package com.Intellivort.AutoSaveAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Intellivort.AutoSaveAPI.Entities.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
