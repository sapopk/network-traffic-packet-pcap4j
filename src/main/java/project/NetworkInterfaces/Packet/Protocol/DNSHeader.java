package project.NetworkInterfaces.Packet.Protocol;

public class DNSHeader {
    private int transactionID;
    private String operationCode;
    private String responseCode;
    private int questionCount;
    private int answerRecordCount;

    public DNSHeader() {}

    public DNSHeader(
        int transactionID,
        String operationCode,
        String responseCode,
        int questionCount,
        int answerRecordCount
    ) {
        this.transactionID = transactionID;
        this.operationCode = operationCode;
        this.responseCode = responseCode;
        this.questionCount = questionCount;
        this.answerRecordCount = answerRecordCount;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationCode() {
        return this.operationCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public int getQuestionCount() {
        return this.questionCount;
    }

    public void setAnswerRecordCount(int answerRecordCount) {
        this.answerRecordCount = answerRecordCount;
    }

    public int getAnswerRecordCount() {
        return this.answerRecordCount;
    }
}
