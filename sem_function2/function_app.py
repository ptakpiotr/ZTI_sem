import azure.functions as func

app = func.FunctionApp(http_auth_level=func.AuthLevel.ANONYMOUS)

@app.function_name(name="http_trigger_queue")
@app.route(route="http_trigger_queue")
@app.queue_output(arg_name="msg", queue_name="tasks", connection="semstorage2_STORAGE")
def http_trigger_queue(req: func.HttpRequest, msg: func.Out[str]) -> func.HttpResponse:
    a = req.params.get('a')
    b = req.params.get('b')

    if a and b:
        try:
            a = float(a)
            b = float(b)
            x = -b / a
            msg.set(f"{a},{b},{x}")
            return func.HttpResponse(f"Miejsce zerowe funckji {a}x + {b} to {x}")
        except e:
            return func.HttpResponse(f"Error: {e}")

    return func.HttpResponse("Please pass all parameters (a and b)")

@app.queue_trigger(arg_name="q", queue_name="tasks", connection="semstorage2_STORAGE") 
@app.blob_output(arg_name="blob", path="files/task.txt", connection="semstorage2_STORAGE")
def queue_trigger(q: func.QueueMessage, blob: func.Out[str]):
    message = q.get_body().decode()
    blob.set(f"Plik zapisany przy użyciu kolejki Azure. Dane: {message}")
    