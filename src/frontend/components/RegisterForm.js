import React, {useState} from "react";
import {
    Button,
    Card,
    CardActions,
    CardContent,
    CardHeader,
    Container, TextField, Typography,
    withStyles
} from "@material-ui/core";
import {DatePicker} from "@material-ui/pickers";
import Palette from "../styles/Palette";
import axios from "axios";


const RegisterForm = () => {

    const RegisterButton = withStyles({
        root: {
            background: Palette.palette.primary.main,
            color: Palette.palette.info.main,
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

    const [selectedBirthday, setSelectedBirthday] = useState(new Date());
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(false);


    const registerUser = () => {
        axios({
            method: "post",
            url: process.env.NEXT_PUBLIC_BACKEND_URL + '/user/register',
            data: new URLSearchParams({
                    firstName: firstname,
                    lastName: lastname,
                    birthday: selectedBirthday.toISOString(),
                    email: email,
                    password: password
                }
            ),
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            }
        }).then(function (res) {
            console.log(res);
        })
            .catch(function (err) {
                console.log(err);
            })
    }

    const registerClickHandler = () => {
        if (firstname === "" || lastname === "" || email === "" || password === "") {
            setError(true)
        } else {
            setError(false)
            registerUser()
            window.location = "/"
        }
    }

    return (
        <Container maxWidth={"xs"}>
            <Card variant={"outlined"}>
                <CardHeader titleTypographyProps={{align: "center"}} title={"Erstelle deinen Account"}/>
                <CardContent>
                    <TextField id={"firstname"} name={"firstname"} label={"Vorname"}
                               onChange={input => setFirstname(input.target.value)} fullWidth/>
                    <TextField id={"lastname"} name={"lastname"} label={"Nachname"}
                               onChange={input => setLastname(input.target.value)} fullWidth/>
                    <DatePicker
                        id={"birthday"}
                        name={"birthday"}
                        disableFuture
                        openTo="year"
                        format="dd/MM/yyyy"
                        label="Geburtstag"
                        views={["year", "month", "date"]}
                        value={selectedBirthday}
                        onChange={setSelectedBirthday}
                        variant={"filled"}
                        fullWidth
                    />
                    <TextField id={"email"} name={"email"} label={"E-Mail"}
                               onChange={input => setEmail(input.target.value)}
                               fullWidth/>
                    <TextField id={"password"} name={"password"} label={"Passwort"} type={"password"}
                               onChange={input => setPassword(input.target.value)} fullWidth/>
                </CardContent>
                <CardActions>
                    <RegisterButton onClick={registerClickHandler} fullWidth>
                        Registrieren
                    </RegisterButton>
                </CardActions>
                <Typography variant={"body2"}
                            style={{
                                color: error ? Palette.palette.error.main : "transparent",
                                textAlign: "center",
                                marginBottom: 16
                            }}>
                    Eingabe überprüfen
                </Typography>
            </Card>
        </Container>
    )
}

export default RegisterForm