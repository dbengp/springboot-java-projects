package com.system.takea_cab.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public record GetaCabRequestOut(Long id, String wearehere, String wegoto, GetaCabRequestStatus status, LocalDateTime creationDate) { }