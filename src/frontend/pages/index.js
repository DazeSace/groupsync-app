import Head from 'next/head'
import DefaultTheme from "../styles/DefaultTheme";
import TopAppBar from "../components/TopAppBar";
import React from "react";
import {Container, Link, MuiThemeProvider} from "@material-ui/core";

const Home = () => {
    return (
        <div>
            <Head>
                <title>Create Next App</title>
                <meta name="description" content="Generated by create next app"/>
                <link rel="icon" href={"/favicon.ico"}/>
            </Head>
            <main>
                <MuiThemeProvider theme={DefaultTheme}>
                    <TopAppBar/>
                    <Container>
                        <Link href={"/register"}>
                            Registrieren
                        </Link>
                    </Container>
                </MuiThemeProvider>
            </main>
        </div>
    )
}
export default Home

