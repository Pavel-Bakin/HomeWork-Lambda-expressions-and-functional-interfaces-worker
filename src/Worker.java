public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;
    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Произошла ошибка на " + i + " задаче");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String errorName);
    }
}
