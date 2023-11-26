package co.com.bancolombia.jpa.entities;

import javax.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder
@Entity
@Table(name = "animales")

public class AnimalesEntity {
    @Id     private String id;
    @Column(nullable = true, length = 250) private String animalesname;
    @Column(nullable = false, length = 350) private String habitat;
    @Column(nullable = true) private boolean genero;
    @Column(nullable = false, length = 50) private int numpatas;
    @Column(nullable = true) private boolean domesticos;

    @Generated
    public static AnimalesEntityBuilder builder() {
        return new AnimalesEntityBuilder();
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public String getAnimalesname() {
        return this.animalesname;
    }

    @Generated
    public String getHabitat() {
        return this.habitat;
    }

    @Generated
    public boolean isGenero() {
        return this.genero;
    }

    @Generated
    public int getNumpatas() {
        return this.numpatas;
    }

    @Generated
    public boolean isDomesticos() {
        return this.domesticos;
    }

    @Generated
    public void setId(String id) {
        this.id = id;
    }

    @Generated
    public void setAnimalesname(String animalesname) {
        this.animalesname = animalesname;
    }

    @Generated
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Generated
    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    @Generated
    public void setNumpatas(int numpatas) {
        this.numpatas = numpatas;
    }

    @Generated
    public void setDomesticos(boolean domesticos) {
        this.domesticos = domesticos;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AnimalesEntity)) {
            return false;
        } else {
            AnimalesEntity other = (AnimalesEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isGenero() != other.isGenero()) {
                return false;
            } else if (this.getNumpatas() != other.getNumpatas()) {
                return false;
            } else if (this.isDomesticos() != other.isDomesticos()) {
                return false;
            } else {
                label54: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label54;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label54;
                    }

                    return false;
                }

                Object this$animalesname = this.getAnimalesname();
                Object other$animalesname = other.getAnimalesname();
                if (this$animalesname == null) {
                    if (other$animalesname != null) {
                        return false;
                    }
                } else if (!this$animalesname.equals(other$animalesname)) {
                    return false;
                }

                Object this$habitat = this.getHabitat();
                Object other$habitat = other.getHabitat();
                if (this$habitat == null) {
                    if (other$habitat != null) {
                        return false;
                    }
                } else if (!this$habitat.equals(other$habitat)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AnimalesEntity;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isGenero() ? 79 : 97);
        result = result * 59 + this.getNumpatas();
        result = result * 59 + (this.isDomesticos() ? 79 : 97);
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $animalesname = this.getAnimalesname();
        result = result * 59 + ($animalesname == null ? 43 : $animalesname.hashCode());
        Object $habitat = this.getHabitat();
        result = result * 59 + ($habitat == null ? 43 : $habitat.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getId();
        return "AnimalesEntity(id=" + var10000 + ", animalesname=" + this.getAnimalesname() + ", habitat=" + this.getHabitat() + ", genero=" + this.isGenero() + ", numpatas=" + this.getNumpatas() + ", domesticos=" + this.isDomesticos() + ")";
    }

    @Generated
    public AnimalesEntity(String id, String animalesname, String habitat, boolean genero, int numpatas, boolean domesticos) {
        this.id = id;
        this.animalesname = animalesname;
        this.habitat = habitat;
        this.genero = genero;
        this.numpatas = numpatas;
        this.domesticos = domesticos;
    }

    @Generated
    public AnimalesEntity() {
    }

    @Generated
    public static class AnimalesEntityBuilder {
        @Generated
        private String id;
        @Generated
        private String animalesname;
        @Generated
        private String habitat;
        @Generated
        private boolean genero;
        @Generated
        private int numpatas;
        @Generated
        private boolean domesticos;

        @Generated
        AnimalesEntityBuilder() {
        }

        @Generated
        public AnimalesEntityBuilder id(String id) {
            this.id = id;
            return this;
        }

        @Generated
        public AnimalesEntityBuilder animalesname(String animalesname) {
            this.animalesname = animalesname;
            return this;
        }

        @Generated
        public AnimalesEntityBuilder habitat(String habitat) {
            this.habitat = habitat;
            return this;
        }

        @Generated
        public AnimalesEntityBuilder genero(boolean genero) {
            this.genero = genero;
            return this;
        }

        @Generated
        public AnimalesEntityBuilder numpatas(int numpatas) {
            this.numpatas = numpatas;
            return this;
        }

        @Generated
        public AnimalesEntityBuilder domesticos(boolean domesticos) {
            this.domesticos = domesticos;
            return this;
        }

        @Generated
        public AnimalesEntity build() {
            return new AnimalesEntity(this.id, this.animalesname, this.habitat, this.genero, this.numpatas, this.domesticos);
        }

        @Generated
        public String toString() {
            return "AnimalesEntity.AnimalesEntityBuilder(id=" + this.id + ", animalesname=" + this.animalesname + ", habitat=" + this.habitat + ", genero=" + this.genero + ", numpatas=" + this.numpatas + ", domesticos=" + this.domesticos + ")";
        }
    }

}
