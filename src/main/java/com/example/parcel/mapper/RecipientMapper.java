package com.example.parcel.mapper;

import com.example.parcel.dto.RecipientDto;
import com.example.parcel.model.Recipient;

public class RecipientMapper {

    private static RecipientDto mapToRecipientDto (Recipient recipient) {
        return new RecipientDto(
                recipient.getId(),
                recipient.getFirstName(),
                recipient.getLastName(),
                recipient.getPhoneNumber(),
                recipient.getPostCode()
        );
    }
    private static Recipient mapToRecipient(RecipientDto recipientDto){
        return  new Recipient(
                recipientDto.getId(),
                recipientDto.getFirstName(),
                recipientDto.getLastName(),
                recipientDto.getPhoneNumber(),
                recipientDto.getPostCode()
        );
    }
}
