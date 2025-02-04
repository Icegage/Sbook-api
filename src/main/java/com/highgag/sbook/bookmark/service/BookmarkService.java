package com.highgag.sbook.bookmark.service;

import com.highgag.sbook.bookmark.domain.Bookmark;
import com.highgag.sbook.bookmark.repository.BookmarkRepository;
import com.highgag.sbook.error.ForbiddenException;
import com.highgag.sbook.user.domain.User;
import com.highgag.sbook.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final UserService userService;

    public void save(Bookmark bookmark){
        bookmarkRepository.save(bookmark);
    }

    public Bookmark findOne(User user, Long id){
        Optional<Bookmark> bookmark = bookmarkRepository.findById(id);
        if (!bookmark.isPresent()) return null;
        userService.isAuthorized(user, bookmark.get());
        return bookmark.get();
    }

    public Bookmark findOne(Long id){
        Optional<Bookmark> bookmark = bookmarkRepository.findById(id);
        if (!bookmark.isPresent()) return null;
        return bookmark.get();
    }
}
