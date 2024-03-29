package co.com.ceiba.edu.drools.facts;


public class VirtualizationRequest {

    private String serverName;
    private Virtualization virtualization;
    private boolean successful;
    private boolean processed;

    public VirtualizationRequest(Virtualization virtualization) {
        this.serverName = virtualization.getServerName();
        this.virtualization = virtualization;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setVirtualization(Virtualization virtualization) {
        this.virtualization = virtualization;
    }

    public Virtualization getVirtualization() {
        return virtualization;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isProcessed() {
        return processed;
    }

}
