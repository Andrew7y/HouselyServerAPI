package com.housely.Repository;

import com.housely.Model.Room.SubImageInRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubImageRepository extends JpaRepository<SubImageInRoom, String> {
}
