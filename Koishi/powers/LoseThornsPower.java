/*    */ package Koishi.powers;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.util.TextureLoader;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ThornsPower;
/*    */ 
/*    */ 
/*    */ public class LoseThornsPower
/*    */   extends AbstractPower
/*    */ {
/* 21 */   public static final String POWER_ID = KoishiMod.makeID("LoseThornsPower");
/* 22 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
/* 23 */   public static final String NAME = powerStrings.NAME;
/* 24 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/* 26 */   private static final Texture tex84 = TextureLoader.getTexture(KoishiMod.makePowerPath("ThornsDown84.png"));
/* 27 */   private static final Texture tex32 = TextureLoader.getTexture(KoishiMod.makePowerPath("ThornsDown32.png"));
/*    */   
/*    */   public LoseThornsPower(AbstractCreature owner, int newAmount) {
/* 30 */     this.name = NAME;
/* 31 */     this.ID = POWER_ID;
/*    */     
/* 33 */     this.owner = owner;
/* 34 */     this.amount = newAmount;
/*    */     
/* 36 */     this.type = AbstractPower.PowerType.DEBUFF;
/* 37 */     this.isTurnBased = false;
/*    */ 
/*    */     
/* 40 */     this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
/* 41 */     this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);
/*    */     
/* 43 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {
/* 48 */     flash();
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new ThornsPower(this.owner, -this.amount), -this.amount));
/* 50 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
/*    */   }
/*    */ 
/*    */   
/*    */   public void onRemove() {
/* 55 */     if ((this.owner.getPower("Thorns")).amount <= 0) {
/* 56 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "Thorns"));
/*    */     }
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 61 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/powers/LoseThornsPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */