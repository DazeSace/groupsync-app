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
import Palette from "../styles/Palette";
import axios from "axios";


const LoginForm = () => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(false);

    const LoginButton = withStyles({
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

    const loginUser = () => {
        axios({
            method: "post",
            url: process.env.NEXT_PUBLIC_BACKEND_URL + '/user/login',
            data: new URLSearchParams({
                    email: email,
                    password: password
                }
            ),
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            }
        }).then(function (res) {
            console.log(res);
            if (res.data === false) {
                setError(true)
            } else {
                setError(false)
                window.location = "/"
            }
        })
            .catch(function (err) {
                console.log(err);
            })
    }

    const loginClickHandler = () => {
        if (email === "" || password === "") {
            setError(true)
        } else {
            setError(false)
            loginUser()
        }
    }

    return (
        <Container maxWidth={"xs"}>
            <Card variant={"outlined"}>
                <CardHeader titleTypographyProps={{align: "center"}} title={"Melde dich an"}/>
                <CardContent>
                    <TextField id={"email"} name={"email"} label={"E-Mail"}
                               onChange={input => setEmail(input.target.value)}
                               fullWidth/>
                    <TextField id={"password"} name={"password"} label={"Passwort"} type={"password"}
                               onChange={input => setPassword(input.target.value)} fullWidth/>
                </CardContent>
                <CardActions>
                    <LoginButton onClick={loginClickHandler} fullWidth>
                        Anmelden
                    </LoginButton>
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

export default LoginForm