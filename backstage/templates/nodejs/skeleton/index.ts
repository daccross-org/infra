import express, { Express, Request, Response } from 'express'
import pinohttp from "pino-http"

const app: Express = express()
app.use(pinohttp())
app.use(express.json())
app.listen(3000, () => console.log('App listening on port 3000'))


app.get('/', async (req: Request, res: Response) => {
  res.send('Hello World!')
})
