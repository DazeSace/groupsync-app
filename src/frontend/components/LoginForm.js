import React from "react";
import {
    Button,
    Card,
    CardActions,
    CardContent,
    CardHeader,
    Container, TextField,
    withStyles
} from "@material-ui/core";
import Palette from "../styles/Palette";


const LoginForm = () => {

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
        <Container maxWidth={"xs"} >
            <Card variant={"outlined"}>
                <CardHeader titleTypographyProps={{align: "center"}} title={"Melde dich an"}/>
                <CardContent>
                    <TextField id={"email"} name={"email"} label={"E-Mail"} fullWidth/>
                    <TextField id={"password"} name={"password"} label={"Passwort"} type={"password"} fullWidth/>
                </CardContent>
                <CardActions>
                    <RegisterButton fullWidth>
                        Anmelden
                    </RegisterButton>
                </CardActions>
            </Card>
        </Container>
    )
}

export default LoginForm