package com.highgag.sbook.domain;

import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class BookmarkList {
    @Id
    @Column(name = "bookmarkList_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    private boolean is_shared;
    private String title;

    @OneToMany
    private List<BookmarkGroup> bookmarkGroupList = new ArrayList<>();

}
