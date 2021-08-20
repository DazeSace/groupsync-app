import React, {useState} from "react";
import {
    Button,
    Card,
    CardActions,
    CardContent,
    CardHeader,
    Container, TextField,
    withStyles
} from "@material-ui/core";
import {DatePicker} from "@material-ui/pickers";
import Palette from "../styles/Palette";


const RegisterForm = () => {

    const [selectedDate, handleDateChange] = useState(new Date());

    const RegisterButton = withStyles({
        root: {
            background: Palette.palette.primary.main,
            color: Palette.palette.info.main,
            marginBottom: 16,
            "&:hover": {
                backgroundColor: Palette.palette.primary.light,
            },
            "&:active": {
                background: Palette.palette.primary.dark,
            },
            "&:focus": {
                background: Palette.palette.primary.main,
            }
        }
    })(Button)

    return (
        <Container maxWidth={"xs"}>
            <Card variant={"outlined"}>
                <CardHeader titleTypographyProps={{align: "center"}} title={"Erstelle deinen Account"}/>
                <CardContent>
                    <TextField id={"firstname"} name={"firstname"} label={"Vorname"} fullWidth/>
                    <TextField id={"lastname"} name={"lastname"} label={"Nachname"} fullWidth/>
                    <DatePicker
                        id={"birthday"}
                        name={"birthday"}
                        disableFuture
                        openTo="year"
                        format="dd/MM/yyyy"
                        label="Geburtstag"
                        views={["year", "month", "date"]}
                        value={selectedDate}
                        onChange={handleDateChange}
                        variant={"filled"}
                        fullWidth
                    />
                    <TextField id={"email"} name={"email"} label={"E-Mail"} fullWidth/>
                    <TextField id={"password"} name={"password"} label={"Passwort"} type={"password"} fullWidth/>
                </CardContent>
                <CardActions>
                    <RegisterButton fullWidth>
                        Registrieren
                    </RegisterButton>
                </CardActions>
            </Card>
        </Container>
    )
}

export default RegisterForm