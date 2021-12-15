package br.edu.ifba.inf011.aval2.observer;

public interface CheckpointListener {
	
	public void notifyRestoreEvent(CheckpointData data);
	public void notifyCheckpointEvent(CheckpointData data);
	
}
