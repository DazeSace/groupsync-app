import {createTheme} from "@material-ui/core";
import Palette from "./Palette";

const appBarMargin = 15

const DefaultTheme = createTheme({
    overrides: {
        MuiContainer: {
            root: {
                backgroundColor: Palette.palette.secondary.light,
            },
            maxWidthXl: {
                background: Palette.palette.primary.main,
            }
        },
        MuiTypography: {
            h2: {
                color: Palette.palette.info.main,
                fontFamily: "sans-serif",
                fontSize: "xx-large",
                fontWeight: "bolder",
                marginTop: appBarMargin,
                marginBottom: appBarMargin
            }
        },
        MuiAppBar: {
            root: {
                background: Palette.palette.primary.main
            },
            colorDefault: {
                backgroundColor: Palette.palette.primary.main
            },
            colorPrimary: {
                background: Palette.palette.primary.main
            }

        }
    }
})

export default DefaultTheme