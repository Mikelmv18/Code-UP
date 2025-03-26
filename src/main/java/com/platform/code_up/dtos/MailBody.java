package com.platform.code_up.dtos;

import lombok.Builder;

@Builder
public record MailBody(String to, String subject, String text) {
}
