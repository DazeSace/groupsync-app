import React from "react";
import {AppBar, Container, Link, Typography} from "@material-ui/core";

const TopAppBar = () => {
    return (
        <AppBar position={"fixed"} color={"default"}>
            <Container maxWidth={"xl"}>
                <Link href={"/"} style={{textDecoration: "none"}}>
                    <Typography variant={"h2"}>groupsync.</Typography>
                </Link>
            </Container>
        </AppBar>
    )
}
export default TopAppBar
