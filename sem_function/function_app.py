import azure.functions as func
import logging

app = func.FunctionApp(http_auth_level=func.AuthLevel.ANONYMOUS)

@app.route(route="HttpTriggerExample")
def HttpTriggerExample(req: func.HttpRequest) -> func.HttpResponse:
    logging.info('Python HTTP trigger function processed a request.')

    name = req.params.get('name')
    age = req.params.get('age')

    if name:
        if not age:
            return func.HttpResponse(f"Hello, {name}. This HTTP triggered function. Add age to URL")
        if int(age) < 18:
            return func.HttpResponse(f"Hello, {name}. You cannot drink beer.")
        else:
            return func.HttpResponse(f"Hello, {name}. You can drink beer.")
    else:
        return func.HttpResponse("Hello from Azure Functions! Add name and age to URL")