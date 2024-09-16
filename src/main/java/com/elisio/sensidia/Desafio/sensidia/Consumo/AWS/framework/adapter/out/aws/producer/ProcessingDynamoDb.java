package com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.adapter.out.aws.producer;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.domain.entities.ProcessingResult;
import com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.adapter.in.dto.UploadResponseDTO;
import com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.adapter.in.dto.UploadResponseDynamoDbDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ProcessingDynamoDb {
    private final DynamoDBMapper dbMapper;

    public ProcessingDynamoDb(DynamoDBMapper dbMapper) {
        this.dbMapper = dbMapper;
    }

    public UploadResponseDynamoDbDTO processingDataSqs(UploadResponseDTO responseDTO, ProcessingResult processingResult) {

        try {
            var resultDetail = new UploadResponseDynamoDbDTO();
            resultDetail.setMessage(processingResult.getMessage());
            resultDetail.setUserId(responseDTO.getUser().getUserId());
            resultDetail.setFileName(responseDTO.getFile().getFileName());
            resultDetail.setFileSize(responseDTO.getFile().getFileSize());
            resultDetail.setProcessingResult(processingResult.getQtdLinhas());
            resultDetail.setStatus(processingResult.getStatus());
            log.info("iniciando save no dynamoDB");
            dbMapper.save(resultDetail);

            log.info("Mensagem enviada com sucesso: " + resultDetail.getFileId());
            return resultDetail;
        } catch (NullPointerException e) {
            log.error("Erro ao criar report, valores nullos: " + e.getMessage());
            throw new NullPointerException("Erro ao criar report, valores nullos: " + e.getMessage());
        }
    }
}
