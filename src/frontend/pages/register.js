import React from "react";
import {Container, MuiThemeProvider} from "@material-ui/core";
import DefaultTheme from "../styles/DefaultTheme"


const Register = () => {
    return(
        <>
            <MuiThemeProvider theme={DefaultTheme}>
                <Container>
                    <p>Hoes</p>
                </Container>
            </MuiThemeProvider>
        </>
    )
}

export default Register