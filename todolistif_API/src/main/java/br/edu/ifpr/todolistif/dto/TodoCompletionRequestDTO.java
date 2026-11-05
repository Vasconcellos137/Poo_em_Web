package br.edu.ifpr.todolistif.dto;

import java.time.LocalDateTime;

public class TodoCompletionRequestDTO {
    private LocalDateTime finishedAt;

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }
}
